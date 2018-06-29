package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

class SingleHorizontalCenteredProgressDrawable extends SingleHorizontalProgressDrawable {

    public SingleHorizontalCenteredProgressDrawable(Context context) {
        super(context);
    }

    @Override
    protected void onDrawRect(Canvas canvas, Paint paint) {
        int level = getLevel();
        if (level == 0) {
            return;
        }

        int saveCount = canvas.save();

        float xFactor = (float) (level / LEVEL_MAX);
        float left = ((RECT_BOUND.right - RECT_BOUND.left) * xFactor) / 2 + RECT_BOUND.left;
        canvas.scale((float) level / LEVEL_MAX, 1, left, 0);

        super.onDrawRect(canvas, paint);
        if (mShowBackground) {
            // Draw twice to emulate the background for secondary progress.
            super.onDrawRect(canvas, paint);
        }

        canvas.restoreToCount(saveCount);
    }
}
