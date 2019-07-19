// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  // auth: 'http://localhost:8004/user',
  // userprofile: 'http://localhost:8005/userprofile',
  // booking: 'http://localhost:8008/booking',
  // warehouse: 'http://localhost:8100/warehouse',
  // recommendation: 'http://localhost:8082/recommendation'

  // auth: 'http://localhost:8004',
  // userprofile: 'http://localhost:8005',
  // booking: 'http://localhost:8008',
  // warehouse: 'http://localhost:8100',
  // recommendation: 'http://localhost:8082'


  // From prod... Defined here.
  auth: 'http://13.234.47.196:8004',
  userprofile:'http://13.234.47.196:8005',
  booking:'http://13.234.47.196:8008',
  warehouse:'http://13.234.47.196:8100',
  recommendation:'http://13.234.47.196:8082',



};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
