This will probably be easier to integrate.


Here's what we'll be doing:  we'll still use the maven spring-boot plugin for packaging, so we end up with a nice
executable jar.  But we'll manually create the spring context, and no longer avail ourselves of any of spring boot's
auto configuration routines.  

It's a little like using a Rolls Royce to go through a McDonald's drive thru.
 
See the AppConfig for the PropertyPlaceholderConfigurer, particularly the check and use of a system property.  This
property is populated in the App class based on a cli parameter.

Once built, run like so:

<pre>
     
java -jar target/tonyas-partial-boot-1.0-SNAPSHOT.jar   # just uses defaults

# use external properties config (but still fall back on application.properties)
java -jar target/tonyas-partial-boot-1.0-SNAPSHOT.jar /home/keith/projects/tonyas-partial-boot/demo.properties   


</pre>

You'll still need @Import or @ImportResources to pull in your own application context (alternatively change the 
package name being passed to AnnotationConfigApplicationContext).

