package com.pagoda.android.asm.privacy.compliance

import com.pagoda.android.asm.privacy.compliance.config.*

class CelledManager {
    private List<BaseMethodCalled> baseMethodCalleds = new ArrayList<>();

    CelledManager() {
        baseMethodCalleds.add(new SettingsCalled())
        baseMethodCalleds.add(new ReflectCalled())
    }

    void init() {
        for (BaseMethodCalled baseMethodCalled : baseMethodCalleds) {
            baseMethodCalled.initConfig();
        }
    }

}