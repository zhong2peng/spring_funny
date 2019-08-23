package com.dnight.core.exception;

/**
 * @author ZHONGPENG769
 * @date 2019/8/23
 */
public class FakeImplException extends RuntimeException{

    public FakeImplException() {
        super("Now is fake impl, not implement");
    }
}
