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

            private User() {
            }
        }

        public class UserRole {

            public static final String USER_ROLE = "UserRole";

            public static final String ROLE_ID = "roleId";

            public static final String USER_ID = "userId";

            private UserRole() {
            }
        }

        private Tables() {
        }

    }

    private Const() {
    }
}
