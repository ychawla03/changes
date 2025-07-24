package com.programming2.class2;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private EasyBank easyBank;

    @Before("execution(* com.Bank.EasyBank.do*(..))")
    public void validateBeforeMethod(JoinPoint joinPoint) {
        int tempPin = easyBank.getTempPin();   // this is set from App
        int actualPin = easyBank.getPinCode(); // from @Value

        System.out.println("Pin validation - temp: " + tempPin + ", actual: " + actualPin);

        if (tempPin != actualPin) {
            throw new RuntimeException("Pin Mismatch - blocked by AOP");
        }
    }
}
