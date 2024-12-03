import { Component, OnInit } from '@angular/core';
import { Oeuvre } from '../model/oeuvre.model';
import { OeuvreService } from '../services/oeuvre.service';
import { Exposition } from '../model/exposition.model';
import { Router } from '@angular/router';
import exp from 'constants';
import { Image } from '../model/image.model';

@Component({
  selector: 'app-add-oeuvre',
  templateUrl: './add-oeuvre.component.html',
})
export class AddOeuvreComponent implements OnInit {
  newOeuvre = new Oeuvre();
  expositions!: Exposition[];
  newIdExposition!: number;
  newExposition!: Exposition;
  uploadedImage!: File;
  imagePath: any;

  constructor(private oeuvreService: OeuvreService, private router: Router) {}
  addOeuvre() {
    /*this.oeuvreService.uploadImage(this.uploadedImage, this.uploadedImage.name).subscribe((img : Image )=>{
      this.newOeuvre.image = img;

    this.newOeuvre.exposition = this.expositions.find(
      (exp) => exp.idExposition == this.newIdExposition
    )!;
    this.oeuvreService.ajouterOeuvre(this.newOeuvre).subscribe((exp) => {
      console.log(exp);
      this.router.navigate(['oeuvres']);
    });
    });*/


    this.newOeuvre.exposition = this.expositions.find(
    (exp) => exp.idExposition == this.newIdExposition
  )!;

  this.oeuvreService.ajouterOeuvre(this.newOeuvre).subscribe((oeuvre: Oeuvre) => {
    console.log('Œuvre ajoutée:', oeuvre);

    if (this.uploadedImage) {
      this.oeuvreService.uploadImageOeuv(this.uploadedImage, this.uploadedImage.name, oeuvre.idOeuvre)
        .subscribe((response) => {
          console.log('Image associée:', response);
          this.router.navigate(['oeuvres']);
        });
    } else {
      this.router.navigate(['oeuvres']);
    }
  });
  }
  ngOnInit(): void {
    this.oeuvreService.listeExpositions().subscribe((exps) => {
      console.log(exps);
      this.expositions = exps._embedded.expositions;
    });
  }

  onImageUpload(event: any) {
    this.uploadedImage = event.target.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(this.uploadedImage);
    reader.onload = (_event) => {
      this.imagePath = reader.result;
    };
  }


}
