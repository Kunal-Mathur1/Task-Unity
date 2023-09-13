import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/service/project/project.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.scss']
})
export class ProjectsComponent implements OnInit {

  public projects:any;

  constructor(private _projectService: ProjectService) {
  }

  ngOnInit() {
    this._projectService.getProject().subscribe(
      (res) => {
        this.projects = res;
        console.log(res);
      },
      (err) => {
        console.log(err)
      }
    )
  }

}
