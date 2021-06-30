package com.training.javaee.cdi;


public enum EProcess {

    ADD {

        @Override
        public int proc(final int a,
                        final int b) {
            return a + b;
        }

    },
    SUBS {

        @Override
        public int proc(final int a,
                        final int b) {
            return a - b;
        }

    },
    MUL {

        @Override
        public int proc(final int a,
                        final int b) {
            return a * b;
        }

    };

    public int proc(final int a,
                    final int b) {
        return a + b;
    }
}
