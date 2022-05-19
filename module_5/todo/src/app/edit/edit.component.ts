import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, FormControl} from '@angular/forms';
import {ITodo} from '../model/ITodo';
import {ActivatedRoute, Router} from '@angular/router';
import {TodoService} from '../service/todo.service';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditTodoComponent implements OnInit {
  formEdit: FormGroup;
  todo: ITodo;
  id: number;

  constructor(private service: TodoService,
              private activatedRouter: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.activatedRouter.paramMap.subscribe((param) => {
      this.id = +param.get('id');
      // @ts-ignore
      this.todo = this.service.findById(this.id).subscribe(
        (todo) => {
          // @ts-ignore
          this.formEdit = new FormGroup({
            id : new FormControl(todo.id),
            content: new FormControl(todo.content)
          });
        });
    });
  }

  updateTodo1(id: number) {

    this.service.updateTodo(id, this.formEdit.value).subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.router.navigateByUrl('/');
      });
  }
}
