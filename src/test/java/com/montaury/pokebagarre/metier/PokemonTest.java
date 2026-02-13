package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Test;

import static com.montaury.pokebagarre.fixtures.ConstructeurDePokemon.unPokemon;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// Cette classe sert à tester la fonction estVainqueurContre(Pokemon autrePokemon) trouvable dans src/main/java/com.montaury.pokebagarre/metier/Pokemon.java
class PokemonTest {
    //LISTE DES TESTS A EFFECTUER :
    //Test des combats :

    //1er Pokémon a meilleure attaque :
    @Test
    void premier_pokemon_devrait_gagner_car_meilleure_attaque() {
        // GIVEN
        Pokemon premier = unPokemon().avecAttaque(65).construire();
        Pokemon second = unPokemon().avecAttaque(55).construire();
        // WHEN
        var estVainqueur = premier.estVainqueurContre(second);
        // THEN
        assertThat(estVainqueur).isTrue();
    }
    //2ème Pokémon a meilleure attaque :
    @Test
    void second_pokemon_devrait_gagner_car_meilleure_attaque() {
        // GIVEN
        Pokemon premier = unPokemon().avecAttaque(55).construire();
        Pokemon second = unPokemon().avecAttaque(65).construire();
        // WHEN
        var estVainqueur = second.estVainqueurContre(premier);
        // THEN
        assertThat(estVainqueur).isTrue();
    }
    //Même ATTK, 1er Pokémon a meilleure défense :
    @Test
    void premier_pokemon_devrait_gagner_car_meilleure_defense() {
        // GIVEN
        Pokemon premier = unPokemon().avecAttaque(55).avecDefense(60).construire();
        Pokemon second = unPokemon().avecAttaque(55).avecDefense(40).construire();
        // WHEN
        var estVainqueur = premier.estVainqueurContre(second);
        // THEN
        assertThat(estVainqueur).isTrue();
    }
    //Même ATTK, 2ème Pokémon a meilleure défense :
    @Test
    void second_pokemon_devrait_gagner_car_meilleure_defense() {
        // GIVEN
        Pokemon premier = unPokemon().avecAttaque(55).avecDefense(40).construire();
        Pokemon second = unPokemon().avecAttaque(55).avecDefense(60).construire();
        // WHEN
        var estVainqueur = second.estVainqueurContre(premier);
        // THEN
        assertThat(estVainqueur).isTrue();
    }
    //Même ATTK et DEF pour les deux Pokémon :
    @Test
    void premier_pokemon_devrait_gagner_car_renseigne_en_premier() {
        // GIVEN
        Pokemon premier = unPokemon().avecAttaque(55).avecDefense(40).construire();
        Pokemon second = unPokemon().avecAttaque(55).avecDefense(40).construire();
        // WHEN
        var estVainqueur = premier.estVainqueurContre(second);
        // THEN
        assertThat(estVainqueur).isTrue();
    }
}