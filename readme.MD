** Qué es un Joinpoint estático en AspectJ

Son puntos en el programa usados para demarcar un método, invocación, constructor, campo, que posteriormente se usarán para identificar una ubicación dentro del programa cuando hay un joinpoint de ejecución (el cual es un evento que ocurre dentro de uno de estos joinpoint estáticos), resumiendo el termino joinpoint estático se refiere a ubicaciones dentro del programa en las que ocurrirán eventos o acciones importantes para demarcar.

Para obtener la parte estática de un JoinPoint se utiliza el metodo getStaticPart(), esto retornará un objeto accesible sobr eel cual una cadena de interceptores / eventos se encuentran instalados.

Es bastante útil usar los joinpoints estáticos para obtener la firma de un metodo dentro de una clase, como se muestra a continuación, como se puede observar ayuda a detectar dinámicamente puntos estáticos dentro del programa:

```
@AfterThrowing(pointcut = "execution(* cn.org.once.cstack.service.ModuleService.remove(..)) " +
    "|| execution(* cn.org.once.cstack.service.ModuleService.initModule(..))",
    throwing = "e")
public void afterThrowingModule(StaticPart staticPart,
                                Exception e)
    throws ServiceException {
    User user = this.getAuthentificatedUser();
    Message message = null;
    logger.debug("CALLED CLASS : " + staticPart.getSignature().getName());
    switch (staticPart.getSignature().getName().toUpperCase()) {
        case initModule:
            message = MessageUtils.writeAfterThrowingModuleMessage(e, user,
                initModule);
            break;
        case deleteType:
            message = MessageUtils.writeAfterThrowingModuleMessage(e, user,
                deleteType);
            break;
    }
    if (message != null) {
        messageService.create(message);
    }
}
```