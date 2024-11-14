package Enginear.eds.ExpenseTracker;

import java.awt.Color;

public enum ETheme {
    PRIMARY(){
        @Override
        protected Color getColor() {
            return new Color(0x01B1D6);
        }
    },
    SECONDARY(){
        @Override
        protected Color getColor() {
            return new Color(0x0C1C1B);
        }
    },
    WHITE(){
        @Override
        protected Color getColor() {
            return new Color(0xFFFFFF);
        }
    },
    BACKGROUND(){
        @Override
        protected Color getColor() {
            return new Color(0x07100F);
        }
    };
    protected abstract Color getColor();
}
