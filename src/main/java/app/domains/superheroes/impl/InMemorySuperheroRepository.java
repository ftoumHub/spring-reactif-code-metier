package app.domains.superheroes.impl;

import app.domains.abilities.Ability;
import app.domains.superheroes.Superhero;
import app.domains.superheroes.SuperheroRepository;
import app.domains.weakness.Weakness;
import io.vavr.API;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.control.Option;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static app.domains.abilities.Ability.*;
import static app.domains.weakness.Weakness.*;
import static io.vavr.API.List;

@Component
public class InMemorySuperheroRepository implements SuperheroRepository {

    private final Map<String, Superhero> superheroMap = HashMap.of(
            "luffy", Superhero.builder()
                    .id("luffy")
                    .name("luffy")
                    .isAvailable(true)
                    .weaknesses(List(Dumb, Water))
                    .abilities(List(ElasticBody, Strength, DoNotGiveUp))
                    .build(),
            "superman", Superhero.builder()
                    .id("superman")
                    .name("superman")
                    .isAvailable(false)
                    .weaknesses(List(Cryptonic))
                    .abilities(List(Strength, LazerEyes, Fly))
                    .build()
    );

    @Override
    public Mono<Option<Superhero>> findByName(String name) {
        return Mono.just(superheroMap.get(name.toLowerCase()));
    }
}
