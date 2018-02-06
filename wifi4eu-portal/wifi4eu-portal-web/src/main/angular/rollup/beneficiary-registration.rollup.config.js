import nodeResolve from 'rollup-plugin-node-resolve';

class RollupNG2 {
    constructor(options){
        this.options = options;
    }
    resolveId(id, from){
        if (id.startsWith('rxjs/')){
            return `${__dirname}/node_modules/rxjs-es/${id.replace('rxjs/', '')}.js`;
        }
    }
}

const rollupNG2 = (config) => new RollupNG2(config);

export default {
    input: 'dist/beneficiary-registration.module.chunk.js',
    output: {
        file: 'dist/beneficiary-registration.module.chunk.js',
        format: 'iife',
        sourcemap: true
    },
    plugins: [
        rollupNG2(),
        nodeResolve({
            jsnext: true, main: true
        })
    ]
};