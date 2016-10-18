package com.lwd.platform.testing.util.constant;

public class Const {

    public static final String DOT = ".";

    public class Bean {

        public class DestroyMethods {

            public static final String CLOSE = "close";

            private DestroyMethods() {
            }
        }

        public static final String USER_DETAILS_SERVICE = "customUserDetailsService";

        private Bean() {
        }
    }

    public class Tables {

        public class User {

            public static final String USER_EMAIL = "email";

            public static final String USER_PASSWORD_HASH = "passwordHash";

            private User() {
            }
        }

        private Tables() {
        }

    }

    private Const() {
    }
}
