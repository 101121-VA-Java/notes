import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokehome',
  templateUrl: './pokehome.component.html',
  styleUrls: ['./pokehome.component.css']
})
export class PokehomeComponent implements OnInit {

  // To use the methods defined in a service, have to inject it in the constructor 
  constructor(private pokeService: PokemonService) { }

  ngOnInit(): void {
  }

  // ?: allows to specify that it's ok for a variable to be null/undefined
  pokemon?: Pokemon;


  getPokemon(id: any){
    this.pokeService.getPokemonById(id).subscribe(
      response => {
        this.pokemon = response;
      }
    );
  }

}
