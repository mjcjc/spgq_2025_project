package kr.ac.tukorea.ge.scgyong.dragonflight.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import kr.ac.tukorea.ge.scgyong.dragonflight.R;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.scene.Scene;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.view.GameView;

public class TitleScene extends Scene {
    private final Bitmap titleBitmap;
    private final Paint paint = new Paint();

    public TitleScene() {
        titleBitmap = BitmapFactory.decodeResource(GameView.view.getResources(), R.mipmap.asteroids_title);
        paint.setTextSize(80f);
        paint.setColor(0xFFFFFFFF);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(titleBitmap, 0, 0, null); // 또는 center로 조정
        canvas.drawText("TAP TO START", canvas.getWidth() / 2f, canvas.getHeight() - 200f, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            new MainScene().push();  // 게임 본편 시작
            Scene.pop();             // 타이틀 씬 제거
            return true;
        }
        return false;
    }
}
