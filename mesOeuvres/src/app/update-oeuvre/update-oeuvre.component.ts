import { Component, Input, OnInit } from '@angular/core';
import { Oeuvre } from '../model/oeuvre.model';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { OeuvreService } from '../services/oeuvre.service';
import { Exposition } from '../model/exposition.model';
import { Image } from '../model/image.model';

@Component({
  selector: 'app-update-oeuvre',
  templateUrl: './update-oeuvre.component.html',
  styles: ``,
})
export class UpdateOeuvreComponent implements OnInit {
  currentOeuvre!: Oeuvre;
  expositions: Exposition[] = [];
  updatedExpId: number = 0; 
  myImage!: string;
  uploadedImage!: File;
  isImageUpdated: Boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private oeuvreService: OeuvreService
  ) {}

  ngOnInit(): void {
    this.oeuvreService.listeExpositions().subscribe((exps) => {
      console.log(exps);
      this.expositions = exps._embedded.expositions;
    });
    this.oeuvreService
      .consulterOeuvre(this.activatedRoute.snapshot.params['id'])
      .subscribe((exp) => {
        this.currentOeuvre = exp;
        this.updatedExpId = this.currentOeuvre.exposition?.idExposition ?? 0;

        /*this.oeuvreService
          .loadImage(this.currentOeuvre.image.idImage)
          .subscribe((img: Image) => {
            this.myImage = 'data:' + img.type + ';base64,' + img.image;
          });*/
      });
  }

  updateOeuvre() {
    this.currentOeuvre.exposition = this.expositions.find(
      (exp) => exp.idExposition == this.updatedExpId
    )!;

   /* if (this.isImageUpdated) {
      this.oeuvreService
        .uploadImage(this.uploadedImage, this.uploadedImage.name)
        .subscribe((img: Image) => {
          this.currentOeuvre.image = img;

          this.oeuvreService
            .updateOeuvre(this.currentOeuvre)
            .subscribe((exp) => {
              this.router.navigate(['oeuvres']);
            });
        });
    } else {*/
      this.oeuvreService.updateOeuvre(this.currentOeuvre).subscribe((oeuv) => {
        this.router.navigate(['oeuvres']);
      });

  }

  onImageUpload(event: any) {
    if (event.target.files && event.target.files.length) {
      this.uploadedImage = event.target.files[0];
      this.isImageUpdated = true;
      const reader = new FileReader();
      reader.readAsDataURL(this.uploadedImage);
      reader.onload = () => {
        this.myImage = reader.result as string;
      };
    }
  }

  onAddImageOeuvre() {
    this.oeuvreService
      .uploadImageOeuv(
        this.uploadedImage,
        this.uploadedImage.name,
        this.currentOeuvre.idOeuvre
      )
      .subscribe((img: Image) => {
        this.currentOeuvre.images.push(img);
      });
  }

  supprimerImage(img: Image) {
    let conf = confirm('Etes-vous sûr ?');
    if (conf)
      this.oeuvreService.supprimerImage(img.idImage).subscribe(() => {
        //supprimer image du tableau currentProduit.images
        const index = this.currentOeuvre.images.indexOf(img, 0);
        if (index > -1) {
          this.currentOeuvre.images.splice(index, 1);
        }
      });
  }
}
