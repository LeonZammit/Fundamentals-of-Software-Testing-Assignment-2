package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_website0 implements _callable{

public static PrintWriter pw; 
public static _cls_website0 root;

public static LinkedHashMap<_cls_website0,_cls_website0> _cls_website0_instances = new LinkedHashMap<_cls_website0,_cls_website0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\leonz\\workspace\\MarketAlertUm2/src/output_website.txt");

root = new _cls_website0();
_cls_website0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_website0 parent; //to remain null - this class does not have a parent!
int no_automata = 2;
 public boolean isLogged =false ;
 public int numOfAlerts =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_website0() {
}

public void initialisation() {
}

public static _cls_website0 _get_cls_website0_inst() { synchronized(_cls_website0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_website0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_website0_instances){
_performLogic_marketAlertUmProp(_info, _event);
_performLogic_alertLimitProp(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_website0[] a = new _cls_website0[1];
synchronized(_cls_website0_instances){
a = _cls_website0_instances.keySet().toArray(a);}
for (_cls_website0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_website0_instances){
_cls_website0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_marketAlertUmProp = 7;

public void _performLogic_marketAlertUmProp(String _info, int... _event) {

_cls_website0.pw.println("[marketAlertUmProp]AUTOMATON::> marketAlertUmProp("+") STATE::>"+ _string_marketAlertUmProp(_state_id_marketAlertUmProp, 0));
_cls_website0.pw.flush();

if (0==1){}
else if (_state_id_marketAlertUmProp==5){
		if (1==0){}
		else if ((_occurredEvent(_event,24/*UserInvalidLogIn*/)) && (isLogged ==false )){
		isLogged =false ;
_cls_website0.pw .println ("Invalid Log In!");

		_state_id_marketAlertUmProp = 5;//moving to state logInPage
		_goto_marketAlertUmProp(_info);
		}
}
else if (_state_id_marketAlertUmProp==6){
		if (1==0){}
		else if ((_occurredEvent(_event,16/*UserLoggedOut*/)) && (isLogged ==true )){
		isLogged =false ;
_cls_website0.pw .println ("User has logged out and is directed to the Home Page");

		_state_id_marketAlertUmProp = 7;//moving to state homePage
		_goto_marketAlertUmProp(_info);
		}
		else if ((_occurredEvent(_event,26/*UserViewedAlerts*/))){
		_cls_website0.pw .println ("Alerts Page is loaded again!");

		_state_id_marketAlertUmProp = 6;//moving to state alertsPage
		_goto_marketAlertUmProp(_info);
		}
}
else if (_state_id_marketAlertUmProp==7){
		if (1==0){}
		else if ((_occurredEvent(_event,18/*logInPressed*/)) && (isLogged ==false )){
		_cls_website0.pw .println ("logInPage is clicked from Home Page(LP)!");

		_state_id_marketAlertUmProp = 5;//moving to state logInPage
		_goto_marketAlertUmProp(_info);
		}
		else if ((_occurredEvent(_event,22/*UserValidLogIn*/))){
		isLogged =true ;
_cls_website0.pw .println ("Valid Log In!");

		_state_id_marketAlertUmProp = 6;//moving to state alertsPage
		_goto_marketAlertUmProp(_info);
		}
		else if ((_occurredEvent(_event,20/*alertsPressed*/)) && (isLogged ==true )){
		_cls_website0.pw .println ("Alerts Page is clicked from Home Page!");

		_state_id_marketAlertUmProp = 6;//moving to state alertsPage
		_goto_marketAlertUmProp(_info);
		}
}
}

public void _goto_marketAlertUmProp(String _info){
_cls_website0.pw.println("[marketAlertUmProp]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_marketAlertUmProp(_state_id_marketAlertUmProp, 1));
_cls_website0.pw.flush();
}

public String _string_marketAlertUmProp(int _state_id, int _mode){
switch(_state_id){
case 5: if (_mode == 0) return "logInPage"; else return "logInPage";
case 6: if (_mode == 0) return "alertsPage"; else return "alertsPage";
case 7: if (_mode == 0) return "homePage"; else return "homePage";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_alertLimitProp = 9;

public void _performLogic_alertLimitProp(String _info, int... _event) {

_cls_website0.pw.println("[alertLimitProp]AUTOMATON::> alertLimitProp("+") STATE::>"+ _string_alertLimitProp(_state_id_alertLimitProp, 0));
_cls_website0.pw.flush();

if (0==1){}
else if (_state_id_alertLimitProp==9){
		if (1==0){}
		else if ((_occurredEvent(_event,28/*AlertCreated*/))){
		numOfAlerts ++;
_cls_website0.pw .println ("Alert Created!");

		_state_id_alertLimitProp = 9;//moving to state staticAPI
		_goto_alertLimitProp(_info);
		}
		else if ((_occurredEvent(_event,30/*AlertsDeleted*/))){
		numOfAlerts =0 ;
_cls_website0.pw .println ("Alerts Deleted!");

		_state_id_alertLimitProp = 9;//moving to state staticAPI
		_goto_alertLimitProp(_info);
		}
		else if ((_occurredEvent(_event,26/*UserViewedAlerts*/)) && (numOfAlerts >5 )){
		_cls_website0.pw .println ("Bad State, user has created more than 5 Alerts!");

		_state_id_alertLimitProp = 8;//moving to state invalidNumberOfAlerts
		_goto_alertLimitProp(_info);
		}
}
}

public void _goto_alertLimitProp(String _info){
_cls_website0.pw.println("[alertLimitProp]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alertLimitProp(_state_id_alertLimitProp, 1));
_cls_website0.pw.flush();
}

public String _string_alertLimitProp(int _state_id, int _mode){
switch(_state_id){
case 9: if (_mode == 0) return "staticAPI"; else return "staticAPI";
case 8: if (_mode == 0) return "invalidNumberOfAlerts"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidNumberOfAlerts "+new _BadStateExceptionwebsite().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}