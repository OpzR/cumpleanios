import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CumpleaniosService {

  constructor(private http:HttpClient) { }

  getSaludoCumpleanios(usuario){          
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
     return this.http.post("http://localhost:8090/api/cumpleanios/get/saludo/", usuario, {headers: headers});     
  }

}
