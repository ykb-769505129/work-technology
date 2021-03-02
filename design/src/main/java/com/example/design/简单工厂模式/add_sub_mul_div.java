package com.example.design.简单工厂模式;

/**
 * 加减乘除类
 */
public class add_sub_mul_div {
}

class OperationAdd extends Operation {

    public double GetResult(){
        double result = 0;
        result = get_numberA() + get_numberB();
        return result;
    }
}

class OperationSub extends Operation {

    public double GetResult(){
        double result = 0;
        result = get_numberA() - get_numberB();
        return result;
    }

}

class OperationMul extends Operation {

    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() * get_numberB();
        return result;
    }
}

class OperationDiv extends Operation {

    @Override
    public double GetResult() throws Exception {
        double result = 0;
        if (get_numberB() == 0)
            throw new Exception("除数不能为0");
        result = get_numberA() / get_numberB();
        return result;
    }

}