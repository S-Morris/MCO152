HW2:  ClockMailer with dependency injection
===
(Due Monday Sept 25)

Using the code from class as a starting point (https://github.com/profyoni/152-FA2017-DependencyInjection1) 
1. Create a new gmail account (do not use your current account)
2. Write a program (`class ClockMailer`) that sends an email to you (at your regular email) when the clock strikes midnight
3. Inject into your `ClockMailer` via c-tor injection (as done in the starter code and in class) two objects: one object implements `IClock` and another which implements `IMailer` as follows
```
interface IClock 
{ 
   LocalDateTime now();
}

interface IMailer 
{	
   void sendMail(String to, String subject, String message);
}
