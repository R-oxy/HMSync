

const path = require("path");
const ImageMinimizerPlugin = require("image-minimizer-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const webpack = require('webpack');

require('dotenv').config({path: './.env'});

module.exports = {
  entry: {
    main: path.resolve('./src/index.js')
  },

  output: {
    path: path.join(__dirname, '..', 'build'),
    filename: 'bundle.js'
  },

  devtool: 'inline-source-map',

  module: {
    rules: [
      {
        test: /\.jsx?$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: [
              ["@babel/preset-env"],
              ["@babel/preset-react", { "runtime": "automatic" }]
            ]
          }
        }
      },

      {
        test: /\.css$/,
        use: ["style-loader", "css-loader"]
      },

      {
        test: /\.(jpe?g|png|gif|svg)$/i,
        type: "asset/resource",
        // use: ['file-loader']
      },
    ],
    
  },

  optimization: {
    minimizer: [
      "...",
      new ImageMinimizerPlugin({
        minimizer: {
          implementation: ImageMinimizerPlugin.imageminMinify,
          options: {
            // Lossless optimization with custom option
            // Feel free to experiment with options for better result for you
            plugins: [
              ["gifsicle", { interlaced: true }],
              ["jpegtran", { progressive: true }],
              ["optipng", { optimizationLevel: 5 }],
              // Svgo configuration here https://github.com/svg/svgo#configuration
              [
                "svgo",
                {
                  plugins: [
                    {
                      name: "preset-default",
                      params: {
                        overrides: {
                          removeViewBox: false,
                          addAttributesToSVGElement: {
                            params: {
                              attributes: [
                                { xmlns: "http://www.w3.org/2000/svg" },
                              ],
                            },
                          },
                        },
                      },
                    },
                  ],
                },
              ],
            ],
          },
        },
      }),
    ],
  },


  devServer: {
    hot: true,
    static: path.resolve(__dirname, 'dist'),
    open: true,
    port: 5021,
    // enables Webpack to utilize routes
    historyApiFallback: true
  },

  plugins: [
    new HtmlWebpackPlugin({
      template: "./dist/index.html",
      filename: "./index.html",
      favicon: "./src/assets/favicon.ico"
    }),
    new webpack.DefinePlugin({
      "process.env": JSON.stringify(process.env),
    }),
  ]

}

console.log('Output Directory:', path.join(__dirname, '..', 'build'));


/* 
entry:
output:
module:
devtools:
devServer:
plugins:
 */