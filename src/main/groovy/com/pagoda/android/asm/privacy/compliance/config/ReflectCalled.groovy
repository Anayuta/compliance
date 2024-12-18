package com.pagoda.android.asm.privacy.compliance.config


import com.pagoda.android.asm.privacy.compliance.entity.MethodCalledBean

class ReflectCalled extends BaseMethodCalled {

    @Override
    public void initConfig() {

        /**
         * method#invoke
         */
        HashMap<String, String> methodInvokeMap = new HashMap<>()
        //key =原始方法签名，value=新方法的签名
        methodInvokeMap.put("(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;")
        MethodCalledBean methodInvokeBean = new MethodCalledBean(
                //原始类
                'java/lang/reflect/Method',
                //原始类方法
                "invoke",
                //原始类方法签名，支持多个(表示多个方法匹配替换，替换到methodInvokeMap的新方法签名上)
                ["(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"] as String[],
                //新的方法代理类
                NEW_METHOD_OWNER,
                //新代理类里用于替换的方法
                "methodInvoke",
                //新代理类方法的类型
                STATIC_OPCODE,
                //新老签名映射
                methodInvokeMap
        )
        addMethodCalledBean(methodInvokeBean)

    }
}