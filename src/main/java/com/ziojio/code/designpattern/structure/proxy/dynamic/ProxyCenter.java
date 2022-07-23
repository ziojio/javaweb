package com.ziojio.code.designpattern.structure.proxy.dynamic;

import com.ziojio.code.designpattern.structure.proxy.IProxy;

public final class ProxyCenter {


    public interface IBeijingProxy extends IProxy {

        String myName();

        void doSell();

        void doProduce();

    }


    public interface INanjingProxy extends IProxy {

        String myName();

        void doSell();

        void doProduce();

    }

}
