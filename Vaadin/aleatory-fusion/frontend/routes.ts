import { Route } from '@vaadin/router';
import './views/main-layout';
import './views/number/number-view';

export type ViewRoute = Route & {
  title?: string;
  icon?: string;
  children?: ViewRoute[];
};

export const views: ViewRoute[] = [
  {
    path: '',
    component: 'number-view',
    icon: '',
    title: '',
  },
  {
    path: 'number',
    component: 'number-view',
    icon: 'la la-not-equal',
    title: 'Number',
  },
];
export const routes: ViewRoute[] = [
  {
    path: '',
    component: 'main-layout',
    children: [...views],
  },
];
