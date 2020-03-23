# Call Center
Imagine you have a call center with three levels of employees: respndent, manager, and director. An incoming telephone call must be first allocated to a respondent who is free. If the respondent cannot handle the call, he or she must escalate the call to a manager. If the manager is not free or not able to handle it, then the call should be escalated to a director. Design the classes and data structures for this problem. Implement a method 'dispathCall()' which assigns a call to the first available employee. 

## SOLUTION
All three ranks of employees have different work to be done, so those specific functions are profile specific. We should keep these thins within their respective class. 

There are a few things which are common to them, like address, name, job title, and age. These things can be kept in one class and can be extneded or inherited by others. 

Finally, there should be on 'CallHandler' class which would route the calls to the correct person. 

Note that on any object-orented design question, there are many ways to design the objects. Discuss the trade-offs of different solutions with your interviewer. You should usually design for long-term code flexibility and maintenance. 

We'll go through each of the calsses below in detail. 

CallHandler represents the body of the program, and all calls are funneled first through it.
```
public class CallHandler{
    /* 3 levels of employees: respondents, managers, directors*/
    private final int LEVELS = 3;

    /* Intialize 10 respondents, 4 managers, and 2 directors.*/
    private final int NUM_RESPONDENTS =10;
    private final int NUM_MANAGERS =4;
    private final int NUM_DIRECTORS =2;

    /* List of employees, by level
    * employeeLevel[0] = respondents
    * employeeLevel[1] = managers
    * employeeLevel[2] = directors
    */
    List<List<Employee>> employeeLevels;

    /*queues for each call's rank*/
    List<List<Call>> callQueues;

    public CallHandler(){ ... }

    /*Gets the first available employee, or saves in a queue if no employee */
    public Employee getHandlerForCall(Call call){ ... }

    /*Routes the call to an availavle employee, or saves in a queue if no employee is available.*/
    public void dispatchCall(Caller caller){
        Call call = new Call(caller);
        dispathCall(call);
    }
    /*Routes the call to an availavle employee, or saves in a queue if no employee is available.*/
    public void (Call call){
        Employee emp = getHandlerForCall(call);
        if(emp != null){
            emp.receiveCall(call);
            call.setHandler(emp);
        }else{
            /*Please the call into corresponding call queue according to its rank.*/
            call.reply("Please wait for free employee to reply.")
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }
    /*An employee got free. Look for a waiting call that employee can serve. Return true if we assigined a call, false otherwise.*/
    public boolean assignCall(Employee emp){ ... }
}
```
'Call' represents a call from a user. A call has a minimum rank and is assigned to the first employee who can handle it.

```
public class Call {
    /* Minimal rank of employee who can handle this call */
    private Rank rank;

    /* Person who is calling. */
    private Caller caller;

    /* Employee who is handling call. */
    private Employee handler;

    public Call(Caller c){
        rank = Rank.Responder;
        caller = c;
    }

    /* Set employee who is handling call.  */
    public void setHandler(Employee e){ handler = e;}

    public void reply(String message) { ... }

    public void reply(String message){ ... }
    public Rank getRank(){ return rank;}
    public Rank incrementRank(){ ... }
    public void disconnect(){ ... }
}
```

Employee is a surper calss for the Director, Manager, and Respondent clasess. It is implemented as an abstract calss since there should be no reason to instaniate an Empolyee type directly. 

```
abstract calss Employee{
    private Call currentCall = null;
    protected Rank rank;

    public Employee(CallHandler handler){ ... }

    /* start the conversation */
    public void receiveCall(Call call) { ... }

    /* the issue is resolved, finish the call */
    public void callCompleted() { ... }

    /* The issue has not been resolved. Escalate the call, and assign a new call to the employee. */ 
    public void escalateAndReassign(){ ... }

    /* Assign a new call to an employee, if the employee is free. */
    public booelan assignNewCall() { ... }

    /* Returns whether or not the employee is free. */
    public boolean isFree(){ return currentCall == null;}

    public Rank getRank(){ return rank;}
}
```

The Respondent, Director, and Manager classes are now just simple extensions of the Employee calss.

```
class Manager extends Employee {
    public Manager(){
        rank = Rank.Manager;
    }
}

class Director extends Employee {
    public Director(){
        rank = Rank.Director;
    }
}

class Respondent extends Employee {
    public Respondent(){
        rank = Rank.Respondent;
    }
}
```
