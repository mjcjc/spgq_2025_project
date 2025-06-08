package kr.ac.tukorea.ge.scgyong.dragonflight.game;

import android.graphics.Canvas;
import android.graphics.RectF;

import java.util.Random;
import kr.ac.tukorea.ge.scgyong.dragonflight.R;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.interfaces.IBoxCollidable;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.interfaces.ILayerProvider;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.interfaces.IRecyclable;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.objects.AnimSprite;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.scene.Scene;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.util.Gauge;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.view.Metrics;

public class Enemy extends AnimSprite implements IRecyclable, IBoxCollidable, ILayerProvider<MainScene.Layer> {
    private static final float SPEED = 300f;
    private static final float RADIUS = 90f;
    private static final int[] resIds = {
            R.mipmap.enemy_01, R.mipmap.enemy_02, R.mipmap.enemy_03, R.mipmap.enemy_04, R.mipmap.enemy_05,
            R.mipmap.enemy_06, R.mipmap.enemy_07, R.mipmap.enemy_08, R.mipmap.enemy_09, R.mipmap.enemy_10,
            R.mipmap.enemy_11, R.mipmap.enemy_12, R.mipmap.enemy_13, R.mipmap.enemy_14, R.mipmap.enemy_15,
            R.mipmap.enemy_16, R.mipmap.enemy_17, R.mipmap.enemy_18, R.mipmap.enemy_19, R.mipmap.enemy_20,
    };
    public static final int MAX_LEVEL = resIds.length - 1;
    private int level;
    private int life, maxLife;
    protected RectF collisionRect = new RectF();
    protected static Gauge gauge = new Gauge(0.1f, R.color.enemy_gauge_fg, R.color.enemy_gauge_bg);
    public static Enemy get(int level, int index) {
        return Scene.top().getRecyclable(Enemy.class).init(level, index);
    }
    public Enemy() {
        super(0, 0, 0);
    }
    private Enemy init(int level, int index) {
        Random rand = new Random();
        this.setImageResourceId(resIds[level], 10);
        int selectRand = rand.nextInt(4);
        switch(3){
            case 0:
                x = rand.nextFloat()* Metrics.width;
                y = RADIUS;
                break;
            case 1:
                x = rand.nextFloat()* Metrics.width;
                y = Metrics.height + RADIUS;
                break;
            case 2:
                x = 0;
                y = rand.nextFloat() * Metrics.height;
                break;
            case 3:
                x = Metrics.width + RADIUS;
                y = rand.nextFloat() *Metrics.height;
                break;
        }
        setPosition(x, y, RADIUS);
        updateCollisionRect();
        this.level = level;
        this.life = this.maxLife = (level + 1) * 10;
        enermyDir();
        return this;
    }

    private void enermyDir() {
        float tx = Metrics.width / 2f;
        float ty = Metrics.height / 2f;
        float dxRaw = tx - x;
        float dyRaw = ty - y;

        float length = (float)Math.sqrt(dxRaw * dxRaw + dyRaw * dyRaw);
        dx = (dxRaw / length) * SPEED;
        dy = (dyRaw / length) * SPEED;
    }


    public int getScore() {
        return (level + 1) * 100;
    }

    public boolean decreaseLife(int power) {
        life -= power;
        return life <= 0;
    }

    @Override
    public void update() {
        super.update();
        if (dstRect.top > Metrics.height) {
            Scene.top().remove(this);
        } else {
            updateCollisionRect();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        float gauge_width = width * 0.7f;
        float gauge_x = x - gauge_width / 2;
        float gauge_y = dstRect.bottom;
        gauge.draw(canvas,gauge_x, gauge_y, gauge_width, (float)life / maxLife);
    }

    private void updateCollisionRect() {
        collisionRect.set(dstRect);
        collisionRect.inset(11f, 11f);
    }

    public RectF getCollisionRect() {
        return collisionRect;
    }

    @Override
    public void onRecycle() {
    }

    @Override
    public MainScene.Layer getLayer() {
        return MainScene.Layer.enemy;
    }
}
