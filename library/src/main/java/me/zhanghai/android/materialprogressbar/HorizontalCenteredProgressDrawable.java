package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * A backported {@code Drawable} for determinate horizontal {@code ProgressBar}.
 */
public class HorizontalCenteredProgressDrawable extends BaseProgressLayerDrawable<
        SingleHorizontalProgressDrawable, HorizontalProgressBackgroundDrawable> {

    /**
     * Create a new {@code HorizontalProgressDrawable}.
     *
     * @param context the {@code Context} for retrieving style information.
     */
    public HorizontalCenteredProgressDrawable(Context context) {
        super(new Drawable[] {
                new HorizontalProgressBackgroundDrawable(context),
                new SingleHorizontalCenteredProgressDrawable(context),
                new SingleHorizontalCenteredProgressDrawable(context)
        }, context);
    }
}
