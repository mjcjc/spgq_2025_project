package kr.ac.tukorea.ge.scgyong.dragonflight.game;

import android.graphics.RectF;

import kr.ac.tukorea.ge.scgyong.dragonflight.R;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.interfaces.IBoxCollidable;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.interfaces.ILayerProvider;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.interfaces.IRecyclable;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.objects.Sprite;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.scene.Scene;

public class Bullet extends Sprite implements IRecyclable, IBoxCollidable, ILayerProvider<MainScene.Layer> {
    private static final float BULLET_WIDTH = 68f;
    private static final float BULLET_HEIGHT = BULLET_WIDTH * 40 / 28;
    private static final float SPEED = 2000f;
    private int power;

    public static Bullet get(float x, float y, int power, float targetX, float targetY) {
        return Scene.top().getRecyclable(Bullet.class).init(x, y, power, targetX, targetY);
    }
    public void BulletDir(float targetX, float targetY){
        float dxRaw = targetX - x;
        float dyRaw = targetY - y;

        float length = (float)Math.sqrt(dxRaw * dxRaw + dyRaw * dyRaw);
        if (length == 0) {
            dx = 0;
            dy = 0;
            return;
        }

        dx = (dxRaw / length) * SPEED;
        dy = (dyRaw / length) * SPEED;
    }

    public Bullet() {
        super(R.mipmap.laser_1);

    }
    private Bullet init(float x, float y, int power, float targetX, float targetY) {
        setPosition(x, y, BULLET_WIDTH, BULLET_HEIGHT);
        this.power = power;
        BulletDir(targetX, targetY);
        return this;
    }
    @Override
    public void update() {
        super.update();
        if (dstRect.bottom < 0) {
            Scene.top().remove(this);
        }
    }

    public int getPower() {
        return power;
    }
    public RectF getCollisionRect() {
        return dstRect;
    }

    @Override
    public void onRecycle() {
    }

    @Override
    public MainScene.Layer getLayer() {
        return MainScene.Layer.bullet;
    }
}
