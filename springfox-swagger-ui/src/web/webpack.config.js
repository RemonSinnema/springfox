const path = require('path');

module.exports = {
  entry: ['babel-polyfill', './js/springfox.js', './scss/tb-swagger-ui.scss'],
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'springfox.js',
  },
  module: {
    rules: [
      {
        test: /\.(jsx|js)$/,
        exclude: /node_modules/,
        use: [{
          loader: 'babel-loader',
          options: {
              presets: [
                  ['@babel/preset-env', {
                      "targets": "defaults"
                  }],
                  '@babel/preset-react'
              ],
              plugins: [
                  [
                      "@babel/plugin-proposal-class-properties",
                      {
                          "loose": true
                      }
                  ]
              ]
          }
        }]
      },
      {
        test: /\.scss$/,
        exclude: /node_modules/,
        use: [
            {
                loader: 'file-loader',
                options: {
                    name: '[name].min.css'
                }
            },
            "sass-loader",
        ]
      }
    ]
  },
  devtool: 'source-map'
};
