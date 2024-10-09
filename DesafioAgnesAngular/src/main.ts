import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { appConfig } from './app/config/app.config';
import {MenuComponent} from './app/components/MenuComponent'; // Importe suas rotas

bootstrapApplication(MenuComponent, {
  ...appConfig, // Mantém as configurações existentes
  providers: [
    ...(appConfig.providers || []), // Garante que os provedores anteriores sejam preservados
    provideHttpClient(withFetch()),
  ],
}).catch((err) => console.error(err));
