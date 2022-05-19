import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ITodo} from '../model/ITodo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  URL_API = 'http://localhost:3000/todos';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<ITodo[]> {
    return this.httpClient.get<ITodo[]>(this.URL_API);
  }

  create(todo: ITodo): Observable<any> {
    return this.httpClient.post(this.URL_API, todo);
  }

  delete(id: number): Observable<ITodo> {
    return this.httpClient.delete(this.URL_API + '/' + id);
  }

  findById(id: number): Observable<ITodo> {
    return this.httpClient.get(this.URL_API + '/' + id);
  }

  updateTodo(id: number, todo: ITodo): Observable<ITodo> {
    return this.httpClient.put(this.URL_API + '/' + todo.id, todo);
  }
}
