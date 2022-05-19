import {Component, OnInit} from '@angular/core';

import {MatDialog} from '@angular/material/dialog';

import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import {min} from 'rxjs/operators';
import {ITodo} from '../model/ITodo';
import {TodoService} from '../service/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class TodoComponent implements OnInit {
  todos: ITodo[] = [];
  content = new FormControl();

  constructor(private service: TodoService) {
  }

  ngOnInit(): void {
    this.service.getAll().subscribe((value) => {
      this.todos = value;
    }, () => {
    }, () => {
    });
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  changeTodo() {
    const value = this.content.value;
    if (value) {
      const todo: ITodo = {
        content: value,
        complete: false
      };
      this.service.create(todo).subscribe(() => {
        this.content.reset();
      }, () => {
      }, () => {
        this.ngOnInit();
      });
    }
  }

  delete(id: number) {
    this.service.delete(id).subscribe();
    this.ngOnInit();
  }

}
