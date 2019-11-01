package com.example.fragmentsdemoapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;


    public class DiceView extends View {

        public RectF rect = new RectF(0, 0, 0, 0);
        public static final int DICE_SIDES = 6;
        public static float DICE_CIRCLE_RADIUS = 0;
        public static int[] RECT_COORDS = {-6, -6, -6, -6};
        public int randomInt = 1;
        public int DICE_DOT_BOTTOM_Y = -6;
        public int DICE_DOT_RIGHT_X = -6;
        public int DICE_DOT_LEFT_X = -6;
        public int DICE_DOT_TOP_Y = -6;
        public int DICE_DOT_CENTER_X = -6;
        public int DICE_DOT_CENTER_Y = -6;
        public int DICE_DOT_LEFT_CENTER_X = -6;
        public int DICE_DOT_RIGHT_CENTER_X = -6;
        public int DICE_RECT_OVAL_X = -6;
        public int DICE_RECT_OVAL_Y = -6;


        Paint paint = new Paint();

        public DiceView(Context context) {
            this(context, null);
        }

        public DiceView(Context context, @Nullable AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public DiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }


        private void rolldice() {
            Random rnd = new Random();
            randomInt = rnd.nextInt(DICE_SIDES) + 1;
        }

        @Override
        public boolean performClick() {
            rolldice();
            invalidate();
            return super.performClick();
        }


        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            paint.setColor(Color.GREEN);

            if (RECT_COORDS[0] == -6) {
                RECT_COORDS[0] = (int) getContext().getResources().getDimension(R.dimen.dice_rect_left);
            }
            if (RECT_COORDS[1] == -6) {
                RECT_COORDS[1] = (int) getContext().getResources().getDimension(R.dimen.dice_rect_top);
            }
            if (RECT_COORDS[2] == -6) {
                RECT_COORDS[2] = (int) getContext().getResources().getDimension(R.dimen.dice_rect_right);
            }
            if (RECT_COORDS[3] == -6) {
                RECT_COORDS[3] = (int) getContext().getResources().getDimension(R.dimen.dice_rect_bottom);
            }
            rect.set(RECT_COORDS[0], RECT_COORDS[1], RECT_COORDS[2], RECT_COORDS[3]);
            if (DICE_CIRCLE_RADIUS == 0) {
                DICE_CIRCLE_RADIUS = getContext().getResources().getDimension(R.dimen.dice_circle_radius);
            }

            if (DICE_DOT_CENTER_X == -6) {
                DICE_DOT_CENTER_X = (int) getContext().getResources().getDimension(R.dimen.dice_dot_center_x);
            }

            if (DICE_DOT_CENTER_Y == -6) {
                DICE_DOT_CENTER_Y = (int) getContext().getResources().getDimension(R.dimen.dice_dot_center_y);
            }

            if (DICE_DOT_LEFT_CENTER_X == -6) {
                DICE_DOT_LEFT_CENTER_X = (int) getContext().getResources().getDimension(R.dimen.dice_dot_left_center_x);
            }

            if (DICE_DOT_RIGHT_CENTER_X == -6) {
                DICE_DOT_RIGHT_CENTER_X = (int) getContext().getResources().getDimension(R.dimen.dice_dot_right_center_x);
            }

            if (DICE_DOT_LEFT_X == -6) {
                DICE_DOT_LEFT_X = (int) getContext().getResources().getDimension(R.dimen.dice_dot_left_x);
            }

            if (DICE_DOT_RIGHT_X == -6) {
                DICE_DOT_RIGHT_X = (int) getContext().getResources().getDimension(R.dimen.dice_dot_right_x);
            }

            if (DICE_DOT_TOP_Y == -6) {
                DICE_DOT_TOP_Y = (int) getContext().getResources().getDimension(R.dimen.dice_dot_top_y);
            }

            if (DICE_DOT_BOTTOM_Y == -6) {
                DICE_DOT_BOTTOM_Y = (int) getContext().getResources().getDimension(R.dimen.dice_dot_bottom_y);
            }

            if (DICE_RECT_OVAL_X == -6) {
                DICE_RECT_OVAL_X = (int) getContext().getResources().getDimension(R.dimen.dice_rect_oval_x);
            }

            if (DICE_RECT_OVAL_Y == -6) {
                DICE_RECT_OVAL_Y = (int) getContext().getResources().getDimension(R.dimen.dice_rect_oval_y);
            }

            canvas.drawRoundRect(rect, DICE_RECT_OVAL_X, DICE_RECT_OVAL_Y, paint);

            paint.setColor(Color.RED);
            switch (randomInt) {

                case 1:
                    canvas.drawCircle(DICE_DOT_CENTER_X, DICE_DOT_CENTER_Y, DICE_CIRCLE_RADIUS, paint);
                    break;

                case 2:
                    canvas.drawCircle(DICE_DOT_LEFT_CENTER_X, DICE_DOT_CENTER_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_CENTER_X, DICE_DOT_CENTER_Y, DICE_CIRCLE_RADIUS, paint);
                    break;

                case 3:
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_TOP_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_CENTER_X, DICE_DOT_CENTER_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_BOTTOM_Y, DICE_CIRCLE_RADIUS, paint);
                    break;

                case 4:
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_TOP_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_BOTTOM_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_TOP_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_BOTTOM_Y, DICE_CIRCLE_RADIUS, paint);
                    break;

                case 5:
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_TOP_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_CENTER_X, DICE_DOT_CENTER_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_BOTTOM_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_BOTTOM_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_TOP_Y, DICE_CIRCLE_RADIUS, paint);
                    break;

                case 6:
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_TOP_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_CENTER_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_LEFT_X, DICE_DOT_BOTTOM_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_TOP_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_CENTER_Y, DICE_CIRCLE_RADIUS, paint);
                    canvas.drawCircle(DICE_DOT_RIGHT_X, DICE_DOT_BOTTOM_Y, DICE_CIRCLE_RADIUS, paint);
                    break;
            }
        }
    }

