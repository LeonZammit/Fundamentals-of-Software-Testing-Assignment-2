package aspects;

import larva.*;
public aspect _asp_website0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_website0.initialize();
}
}
before () : (call(* *.UserLoggedOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 16/*UserLoggedOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 16/*UserLoggedOut*/);
}
}
before () : (call(* *.UserValidLogIn(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 22/*UserValidLogIn*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 22/*UserValidLogIn*/);
}
}
before () : (call(* *.AlertsDeleted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 30/*AlertsDeleted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 30/*AlertsDeleted*/);
}
}
before () : (call(* *.UserInvalidLogIn(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 24/*UserInvalidLogIn*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 24/*UserInvalidLogIn*/);
}
}
before () : (call(* *.alertsPressed(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 20/*alertsPressed*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 20/*alertsPressed*/);
}
}
before () : (call(* *.AlertCreated(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 28/*AlertCreated*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 28/*AlertCreated*/);
}
}
before () : (call(* *.UserViewedAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 26/*UserViewedAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 26/*UserViewedAlerts*/);
}
}
before () : (call(* *.logInPressed(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_website0.lock){

_cls_website0 _cls_inst = _cls_website0._get_cls_website0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 18/*logInPressed*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 18/*logInPressed*/);
}
}
}