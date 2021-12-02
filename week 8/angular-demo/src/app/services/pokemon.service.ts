import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  // in order to leverage http client, has to be injected
  constructor(private http: HttpClient) { }

  getPokemonById(id: number): Observable<Pokemon>{
    return this.http.get('https://pokeapi.co/api/v2/pokemon/'+id)
      .pipe(
        map(response => response as Pokemon)
      )
  }
}
