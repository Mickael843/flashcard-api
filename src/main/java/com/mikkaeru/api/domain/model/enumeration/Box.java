package com.mikkaeru.api.domain.model.enumeration;

public enum Box {

    BOX_ONE(1),
    BOX_TWO(2),
    BOX_THREE(3),
    BOX_FOUR(4),
    BOX_FIVE(5);

    final int number;

    Box(int number) {
        this.number = number;
    }

    public static Box nextBox(Box currentBox) {

        switch (currentBox) {
            case BOX_ONE:
                return BOX_TWO;
            case BOX_TWO:
                return BOX_THREE;
            case BOX_THREE:
                return BOX_FOUR;
            default:
                return BOX_FIVE;
        }
    }

    public static Box backOneBox(Box currentBox) {

        switch (currentBox) {
            case BOX_FIVE:
                return BOX_FOUR;
            case BOX_FOUR:
                return BOX_THREE;
            case BOX_THREE:
                return BOX_TWO;
            default:
                return BOX_ONE;
        }
    }
}
