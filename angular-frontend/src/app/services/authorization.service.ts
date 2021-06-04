import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

export class User {
  username: string;
  password?: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  constructor(private httpClient: HttpClient) { }

  // login(username: string, password: string){
  //   const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)});
    
  //   return this.httpClient.get("http://localhost:8080/",{headers, responseType:'text' as 'json'});
  // }


  login(username: string, password: string){
    const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)});
    
    return this.httpClient.post("http://localhost:8080/login",{headers, responseType:'text' as 'json'});
  }

  public getUsers(username){
  
  }

  authenticate(username: string, password: string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<User>('http://localhost:8080/',{headers}).pipe(map(
       userData => {
        sessionStorage.setItem('username',username);
        return userData;
       }));
  }

  
}

