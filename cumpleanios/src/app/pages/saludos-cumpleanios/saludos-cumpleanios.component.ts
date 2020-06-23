import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CumpleaniosService } from 'src/app/services/cumpleanios.service';

@Component({
  selector: 'app-saludos-cumpleanios',
  templateUrl: './saludos-cumpleanios.component.html',
  styleUrls: ['./saludos-cumpleanios.component.css']
})
export class SaludosCumpleaniosComponent implements OnInit {

  usuarioResponse = {
    nombres: "",
    apellido: "",
    nacimiento: "",
    poema: "",
    edad: "",
    fecha: ""
  }

  constructor(private cumpleaniosService: CumpleaniosService) { }


  ngOnInit(): void {

  }

  guardar(formCumple: NgForm) {
    if (formCumple.invalid) {
      Object.values(formCumple.controls).forEach(control => {
        control.markAsTouched();
      });
      return;
    }
    else {
      let usuario = {
        nombres: formCumple.form.controls.nombres.value,
        apellido: formCumple.form.controls.apellido.value,
        nacimiento: formCumple.form.controls.nacimiento.value
      };
      console.log("usuario", usuario);
      this.cumpleaniosService.getSaludoCumpleanios(usuario).subscribe(response => {
        this.usuarioResponse.nombres = (response as any).nombres;
        this.usuarioResponse.apellido = (response as any).apellido;
        this.usuarioResponse.poema = (response as any).poema;
        this.usuarioResponse.edad = (response as any).edad;
        this.usuarioResponse.fecha = (response as any).fecha;
      });
    }
  }

}
