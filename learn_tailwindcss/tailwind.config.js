// tailwind.config.js
module.exports = {
    content:["./src/**/*.html", './src/**/*.{js,ts,jsx,tsx}', './templates/**/*.html'],
    safelist: ["ps-[var(--sidebar-padding)]","pe-[var(--sidebar-padding)]"],
    theme: {
        extend: {
            breakBefore: {
                page: 'page',
            },
            breakAfter: {
                page: 'page',
            },
            margin: {
                custom: 'var(--my-margin)'
            },
            fontFamily: {
                roboto: ['"Roboto"', 'sans-serif']
            }
        },
    },
    variants: {
        extend: {
        breakBefore: ['print'],
        breakAfter: ['print'],
        utilities: {
            '.break-inside-avoid':{
                breakInside: 'avoid',
                pageBreakInside: 'avoid',
                display: 'block'
            }
        }
        },
    },
    plugins:[],
    corePlugins: {
        preflight: true
    }
}