// import { Injectable } from '@angular/core';
// import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthGuardService  implements CanActivate{

//   constructor(private auth : AuthService, private myroute:Router) { }

//   canActivate(
//     next:ActivatedRouteSnapshot,
//     state:RouterStateSnapshot) : Observable<boolean> | Promise <boolean> | boolean {
//       if(this.auth.isLoggedIn()) {
//         return true;
//       }

//       else {
//         this.myroute.navigate(["login"]);
//         return false;
//       }
//     }
// }
