package app.domains.abilities;

import io.IO;
import app.domains.superheroes.Superhero;
import app.entities.Problem;
import io.vavr.API;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import org.springframework.stereotype.Component;

import static app.domains.abilities.Ability.*;
import static io.vavr.API.List;

@Component
public class Abilities {

    private final Map<Problem, List<Ability>> IA = HashMap.of(
            Problem.BanditInTown, List(DistanceFight, MeleeFight, MidDistanceFight, IronBody),
            Problem.CarAccident, List(Fly, Strength),
            Problem.FellIntoWater, List(Dive),
            Problem.SuperVilain, List(LazerEyes, IronBody, ElasticBody)
    );

    public IO<AbilitiesError, List<Ability>> checkAbilities(Superhero superhero, Problem problem) {

        List<Ability> requiredAbilities = IA.getOrElse(problem, List.empty());

        List<Ability> usableAbilities = superhero.abilities.filter(requiredAbilities::contains);
        if (usableAbilities.isEmpty()) {
            return IO.error(new AbilitiesError.AbilityUnmatch());
        } else {
            return IO.succeed(usableAbilities);
        }
    }

}
