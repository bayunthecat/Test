package com.lwd.platform.testing.repo.tools;

import java.io.Serializable;

public interface IdInjectionStrategy {

    Object injectId(Object object, Object id);

    Serializable getId(Object object);
}
