package com.ziojio.code.designpattern.behavior.state;

/**
 * η―ηηΆζ
 *
 * @author xuexiang
 * @since 2020/3/29 12:13 AM
 */
public interface LightState {

    void pressSwitch(Light light);

    String stateName();
}
