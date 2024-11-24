package Enginear.eds.ExpenseTracker.model;

import java.awt.Color;

public enum ETheme {
    PRIMARY(){
        @Override
        public Color getColor() {
            return new Color(0x01B1D6);
        }
    },
    SECONDARY(){
        @Override
        public Color getColor() {
            return new Color(0x0C1C1B);
        }
    },
    WHITE(){
        @Override
        public Color getColor() {
            return new Color(0xFFFFFF);
        }
    },
    BACKGROUND(){
        @Override
        public Color getColor() {
            return new Color(0x07100F);
        }
    };
    public abstract Color getColor();
}
