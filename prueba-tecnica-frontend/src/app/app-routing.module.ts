import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { CatComponent } from './pages/cat/cat.component';
import { SearchComponent } from './pages/search/search.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { authGuard } from './core/guard/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: CatComponent,
    canActivate: [authGuard],
    children: [
      {
        path: '',
        loadChildren: () => import('./pages/cat/cat.module').then(m => m.CatModule)
      }
    ]
  },
  {
    path: 'search',
    component: SearchComponent,
    canActivate: [authGuard],
    children: [
      {
        path: 'search',
        loadChildren: () => import('./pages/search/search.module').then(m => m.SearchModule)
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent,
    children: [
      {
        path: 'login',
        loadChildren: () => import('./pages/login/login.module').then(m => m.LoginModule)
      }
    ]
  },
  {
    path: 'register',
    component: RegisterComponent,
    children: [
      {
        path: 'register',
        loadChildren: () => import('./pages/register/register.module').then(m => m.RegisterModule)
      }
    ]
  },
  {
    path: '**',
    loadChildren: () => import('./pages/not-found/not-found.module').then(m => m.NotFoundModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    preloadingStrategy: PreloadAllModules
  })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
