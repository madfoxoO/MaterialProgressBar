package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

class SingleHorizontalCenteredProgressDrawable
        extends BaseSingleHorizontalProgressDrawable
        implements ShowBackgroundDrawable {

    /**
     * Value from {@link android.graphics.drawable.Drawable#getLevel()}
     */
    private static final int LEVEL_MAX = 10000;

    private boolean mShowBackground;

    SingleHorizontalCenteredProgressDrawable(Context context) {
        super(context);
    }

    @Override
    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }

    @Override
    public boolean getShowBackground() {
        return mShowBackground;
    }

    @Override
    public void setShowBackground(boolean show) {
        if (mShowBackground != show) {
            mShowBackground = show;
            invalidateSelf();
        }
    }

    @Override
    protected void onDrawRect(Canvas canvas, Paint paint) {
        int level = getLevel();
        if (level == 0) {
            return;
        }

        int saveCount = canvas.save();

        float scaleX = (float) level / LEVEL_MAX;
        float width = RECT_BOUND.right - RECT_BOUND.left;
        float filledWidth = width * scaleX;
        float translateX = (width - filledWidth) / 2F;
        canvas.translate(translateX, 0);
        canvas.scale(scaleX, 1, RECT_BOUND.left, 0);

        super.onDrawRect(canvas, paint);
        if (mShowBackground) {
            // Draw twice to emulate the background for secondary progress.
            super.onDrawRect(canvas, paint);
        }

        canvas.restoreToCount(saveCount);
    }
}
