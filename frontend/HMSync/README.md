
# Hotel Management System

This is a Hotel Management System project built using React and Webpack.

## Table of Contents
- [Installation](#installation)
- [Scripts](#scripts)
- [Dependencies](#dependencies)
- [Dev Dependencies](#dev-dependencies)
- [License](#license)


## Languages & Technologies used
- Javascript(`React`)
- HTML
- CSS

## Installation

To install the dependencies, run:

```bash
npm install
```

### Environment Variables
Ensure to create a `.env` file at the root of the project and configure necessary environment variables as project uses `dotenv` for managing environment variables.

## Scripts

npm scripts are:

- **Development Server**: Runs the project in development mode with hot-reloading:
  ```bash
  npm run dev
  ```
  Starts the `webpack-dev-server`.

- **Build**: Builds the project for production:
  ```bash
  npm run build
  ```
  Bundles the app using Webpack.

- **Check Build Dependencies**: Audits the production dependencies:
  ```bash
  npm run check-build-dependencies
  ```

## Dependencies

The main dependencies used:

- **React**: `^18.3.1`
- **React Router**: `^6.27.0`
- **React Query**: `^5.59.13` - Fetching & Posting Data in a streamlined fashion
- **@auth-kit/react-router** `^3.1.3` - Authentication & JWT Token management
- **dotenv**: `^16.4.5`
- **Material UI**, **@emotion/react** and **@emotion/styled** as dependencies for plotting graphs 


## Dev Dependencies

Main DevDependencies used:

- **Babel**: `^7.25.7` : Compiling JavaScript and React code
- **Webpack**: `^5.95.0`
  - `html-webpack-plugin`: Generation of HTML files
  - `babel-loader`: Transpiling of JavaScript files using Babel
  - **Image minimization plugins**: Optimizing images (GIFs, PNGs, SVGs, JPEGs)
- **Style-loader** and **CSS-loader** for processing CSS
- **Eslint-plugin-query** for React Query linting

## License

This project is licensed under the MIT License.
