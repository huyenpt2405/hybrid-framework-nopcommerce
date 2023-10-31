package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${env}.properties"})
public interface Environment extends Config {
	@Key("app.url")
	String appUrl();
	
	@Key("app.user")
	String appUsername();
	
	@Key("app.pass")
	String appPassword();
	
	@Key("db.host")
	String dbHostname();
	
	@Key("db.user")
	String dbUsername();
	
	@Key("db.pass")
	String dbPassword();
}
