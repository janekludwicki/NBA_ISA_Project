package student.pg.edu.pl.NBA.ISA;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator (RouteLocatorBuilder builder,
									  @Value("${player.url}") String playerUrl,
									  @Value("${team.url}") String teamUrl,
									  @Value("${gateway.host}") String host) {
		return builder
				.routes()
				.route("players", route -> route
						.host(host)
						.and()
						.path(
								"/api/players/{id}",
								"/api/players",
								"/api/teams/{id}/players"
						)
						.uri(playerUrl)
				)
				.route("teams", route -> route
						.host(host)
						.and()
						.path(
								"/api/teams/{id}",
								"/api/teams"
						)
						.uri(teamUrl)
				)
				.build();

	}
}
