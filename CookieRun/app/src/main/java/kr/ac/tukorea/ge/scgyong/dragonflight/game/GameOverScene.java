package kr.ac.tukorea.ge.scgyong.dragonflight.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import kr.ac.tukorea.ge.scgyong.dragonflight.R;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.scene.Scene;
import kr.ac.tukorea.ge.spgp2025.a2dg.framework.view.GameView;

public class GameOverScene extends Scene {
    private final Paint paint = new Paint();
    private Bitmap bg;

    public GameOverScene() {
        // 여기 고침 👇
        bg = BitmapFactory.decodeResource(GameView.view.getResources(), R.mipmap.astrobg);

        paint.setColor(Color.WHITE);
        paint.setTextSize(100);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawBitmap(bg, null, new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), null);

        float cx = canvas.getWidth() / 2f;
        float cy = canvas.getHeight() / 2f;

        canvas.drawText("GAME OVER", cx, cy, paint);
        canvas.drawText("Tap to Restart", cx, cy + 120, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Scene.pop();
            new MainScene().push();
            return true;
        }
        return false;
    }
}

